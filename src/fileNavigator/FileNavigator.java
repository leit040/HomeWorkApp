package fileNavigator;

import java.util.*;

public class FileNavigator {

    String path;
    FileNavigator parent;
    HashMap<String, FileData> fileMap;
    TreeMap<String, FileNavigator> subcatalogsMap;

    public FileNavigator(String path, FileNavigator parent) {
        this.path = path;
        this.parent = parent;
        this.fileMap = new HashMap<String, FileData>();
        this.subcatalogsMap = new TreeMap<String, FileNavigator>();
    }

    FileNavigator searchPath(String path) {
        if (this.path.equals(path)) {
            return this;
        }
        FileNavigator fn;
        for (FileNavigator fileNavigator : this.subcatalogsMap.values()) {
            fn = fileNavigator.searchPath(path);
            if (fn != null) {
                return fn;
            }
        }
        return null;
    }


    void addFile(FileData file) {
        if (this.path.equals(file.path)) {
            if (!this.fileMap.containsKey(file.name)) {
                fileMap.put(file.name, file);

            } else {
                System.out.printf("You can't add file %s: directory %s contain file with some name!\n", file.name, path);
            }
        }
    }

    void add(FileData file) {
        FileNavigator fileNavigator = this.searchPath(file.path);

        if (fileNavigator != null) {
            fileNavigator.addFile(file);
        } else {
            System.out.printf("You can't add file %s: filepath isn't correct!\n", file.path);
        }

    }

    void addSubCatalog(String path) {
        if (this.findFileNavigator(path) != null) {
            System.out.printf("You can't add path %s - it already exits!\n", path);
        }

        String pathWithoutLast = path.substring(0, path.lastIndexOf("/"));
        FileNavigator fn = this.findFileNavigator(pathWithoutLast);

        if (fn != null) {
            fn.subcatalogsMap.put(path, new FileNavigator(path, fn));
        } else {
            System.out.printf("You can't add subcatalog  %s: filepath isn't correct!\n", path);
        }
    }

    private FileNavigator findFileNavigator(String path) {
        FileNavigator result;
        if (this.path.equals(path)) {
            return this;
        }
        for (FileNavigator fileNavigator : this.subcatalogsMap.values()) {
            result = fileNavigator.findFileNavigator(path);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    HashMap<String, FileData> find(String path) {
        FileNavigator fileNavigator = this.findFileNavigator(path);
        return fileNavigator != null ? fileNavigator.fileMap : null;
    }

    List<FileData> filterBySize(int size) {
        List<FileData> result = new ArrayList<FileData>();
        for (FileNavigator fileNavigator : subcatalogsMap.values()) {
            result.addAll(fileNavigator.filterBySize(size));
        }
        for (FileData file : fileMap.values()
        ) {
            if (file.size <= size) {
                result.add(file);
            }
        }
        return result;
    }

    Map<Integer, FileData> sortBySize() {
        TreeMap<Integer, FileData> result = new TreeMap<Integer, FileData>();
        for (FileNavigator fileNavigator : this.subcatalogsMap.values()) {
            result.putAll(fileNavigator.sortBySize());
        }
        for (FileData fd:this.fileMap.values()) {
            result.put(fd.size,fd);
        }

        return result;
    }

    void remove(String path) {
        FileNavigator fn = findFileNavigator(path);
        if (fn != null) {
          fn.parent.subcatalogsMap.remove(path);
        }
    }


}
