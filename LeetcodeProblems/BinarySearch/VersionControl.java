package BinarySearch;

public class VersionControl {
    int firstBad;
    public boolean isBadVersion(int version){
        if(version >= firstBad) return true;
        return false;
    }
}
