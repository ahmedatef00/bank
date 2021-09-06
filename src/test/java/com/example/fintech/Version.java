package com.example.fintech;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Version implements Comparable<Version> {

    public static final String errorVersionMustNotBeNull = "'version' must not be null!";
    public static final String errorOtherMustNotBeNull = "'other' must not be null!";
    public static final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    private static Pattern versionPattern = Pattern.compile("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?");

    final private String version;

    Version() {
        this(null);
    }

    Version(String version) {
        if (version == null) {
            throw new IllegalArgumentException(errorVersionMustNotBeNull);
        }
        if (!versionPattern.matcher(version).matches()) {
            throw new IllegalArgumentException(errorVersionMustMatchPattern);
        }
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public boolean isSnapshot() {
        return version.contains("-SNAPSHOT");
    }

    @Override
    public int compareTo(Version o) {
        if (o == null) {
            throw new IllegalArgumentException(errorOtherMustNotBeNull);
        }
        String[] split1 = version.split("-");
        System.out.println(Arrays.toString(split1));
        String[] split2 = o.getVersion().split("-");
        System.out.println(Arrays.toString(split2));

        int r1 = split1[0].compareTo(split2[0]);
        int r2 = Integer.compare(split1.length, split2.length);
        return r1 < 0 ? -1 : r1 > 0 ? +1 : r2 == 0 ? 0 : r2 > 0 ? -1 : +1;
    }

    @Override
    public int hashCode() {
        return version.hashCode();
    }
}
