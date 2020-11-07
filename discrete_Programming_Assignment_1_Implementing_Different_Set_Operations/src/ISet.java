public interface ISet {
    /**
     * prints the UnionOfTwoSets
     * @param s1 first set as an array of string
     * @param s2 second set as an array of string
     * and print it
     */
    public void UnionOfTwoSets(String[] s1,String[] s2);
    /**
     * prints the IntersectionOfTwoSets
     * @param s1 first set as an array of string
     * @param s2 second set as an array of string
     * and print it
     */
    public void IntersectionOfTwoSets(String[] s1,String[] s2);
    /**
     * prints the ComplementOfASet
     * @param s1 the set as an array of string
     * @param u  the universe set as an array of string
     * and print it
     */
    public void ComplementOfASet(String[] s1,String[] u);
    /**
     * the execution of the operators of the set operations
     * @param n the choice of the menu
     */
    public void execution(int n);
    /**
     * @param n number of sets
     * @param u the universe
     * and store them in the object of the setApp
     */
    public void ReadSetsAndStoreThem(int n, String u);
}
