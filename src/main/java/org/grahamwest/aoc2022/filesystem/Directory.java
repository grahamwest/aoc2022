package org.grahamwest.aoc2022.filesystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Directory {

    public Directory(Directory parent) {
        this.parent = parent;
    }

    public static Directory fs() {
        Directory fs = new Directory(null);
        Directory root = new Directory(null);
        fs.directories.put("/", root);
        return fs;
    }

    private Directory parent;
    private Map<String, Directory> directories = new HashMap<>();
    private Map<String,Long> files = new HashMap<>();

    public void parse(Iterator<String> cmds) {
        while (cmds.hasNext()) {
            String line = cmds.next();

            if (line.startsWith("$ cd")) {
                String[] lineParts = line.split(" ");
                String cmd = lineParts[1];
                String dirName = lineParts[2];

                if (cmd.equals("cd")) {
                    Directory dir = null;
                    if ("..".equals(dirName)) {
                        dir = this.parent;
                    } else {
                        dir = directories.get(dirName);
                    }
                    dir.parse(cmds);
                }
            } else if (line.startsWith("dir")) {
                String[] lineParts = line.split(" ");
                this.directories.put(lineParts[1], new Directory(this));
            } else if (!line.startsWith("$")) {
                String[] lineParts = line.split(" ");
                files.put(lineParts[1], Long.valueOf(lineParts[0]));
            }
        }
    }

    public Directory getDirectory(String name) {
        return this.directories.get(name);
    }

    public Stream<Directory> getDirectory(final Predicate<Directory> test) {
        Stream<Directory> dirs = this.directories.values().stream().filter(test);
        Stream<Directory> subDirs = this.directories.values().stream().flatMap( d->d.getDirectory(test));

        return Stream.concat(dirs, subDirs);
    }

    public long filesize() {
        long size = 0;
        size += this.files.values().stream().mapToLong(Long::longValue).sum();
        size += this.directories.values().stream().mapToLong(Directory::filesize).sum();
        return size;
    }

}
