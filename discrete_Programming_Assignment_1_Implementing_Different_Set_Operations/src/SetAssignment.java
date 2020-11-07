import java.util.Arrays;
import java.util.Scanner;
public class SetAssignment implements ISet{
    private doubleLinkedList sets = new doubleLinkedList();
    private String[] union;
    /**
     * convert line of strings to array of strings
     * @param s the string of the whole line
     * @return the array of the strings
     */
    private String[] StringToArrString(String s){
        String[] stringsArr = s.split("\\s+");
        if (stringsArr.length!=1){
            int count=0;
            for(String str : stringsArr){
                if(str.isEmpty()){
                    count++;
                }
            }
            String[]strings=new String[stringsArr.length-count];
            int i=0;
            for(String str : stringsArr){
                if(!str.isEmpty()){
                    strings[i]=str;
                    i++;
                }
            }
            return strings;
        }
        return stringsArr;
    }
    private String[] noDuplicates(String[] s){
        String[] tempo=s;
        int count=0;
        for (int i=0;i<tempo.length;i++){
            for (int j=0;j< tempo.length;j++){
                if (tempo[i]!=null&&tempo[j]!=null&&tempo[i].equals(tempo[j])&&i!=j){
                    tempo[i]=null;
                }
            }
        }
        for (int i=0;i<tempo.length;i++){
            if (tempo[i]!=null){
                count++;
            }
        }
        String[] temp=new String[count];
        int j=0;
        for (int i=0;i< tempo.length;i++){
            if (tempo[i]!=null){
                temp[j]=tempo[i];
                j++;
            }
        }
        return temp;
    }
    //to make the program dynamic
    private class doubleLinkedList {
        private class doubleLinkedListNode {
            private Object element;
            private doubleLinkedListNode next, prev;
            private doubleLinkedListNode() {
                element = null;
                prev = null;
                next = null;
            }
            private doubleLinkedListNode(Object e, doubleLinkedListNode p, doubleLinkedListNode n) {
                element = e;
                prev = p;
                next = n;
            }
            /**
             * Returns the element of this node
             */
            private Object getElement() {
                return element;
            }
            /**
             * Returns the previous node of this node
             */
            private doubleLinkedListNode getPrev() {
                return prev;
            }
            /**
             * Returns the next node of this node
             */
            private doubleLinkedListNode getNext() {
                return next;
            }
            /**
             * Sets the element of this node
             */
            private void setElement(Object newElem) {
                element = newElem;
            }
            /**
             * Sets the previous node of this node
             */
            private void setPrev(doubleLinkedListNode newPrev) {
                prev = newPrev;
            }
            /**
             * Sets the next node of this node
             */
            private void setNext(doubleLinkedListNode newNext) {
                next = newNext;
            }
        }
        ///////////////////////the linked list//////////////////////////
        private int size; // number of elements
        private doubleLinkedListNode header, trailer; // sentinels
        // Constructor that creates an empty list
        private doubleLinkedList() {
            int Size = 0;
            header = new doubleLinkedListNode(null, null, null); // create header
            trailer = new doubleLinkedListNode(null, header, null); // create trailer
            header.setNext(trailer); // make header and trailer point to each other
        }
        /**
         * Inserts the specified element at the end of the list.
         * @param element
         */
        private void add(Object element){
            doubleLinkedListNode newNode=new doubleLinkedListNode(element, null, null);
            trailer.getPrev().setNext(newNode);
            newNode.setPrev(trailer.getPrev());
            trailer.setPrev(newNode);
            newNode.setNext(trailer);
            size++;
        }
        /**
         * @param index
         * @return the element at the specified position in this list.
         */
        private Object get(int index){
            index--;
            if (index>=0) {
                doubleLinkedListNode temp = header;
                int i = -1;
                while (temp.getNext() != trailer & i < index) {
                    i++;
                    temp = temp.getNext();
                }
                if (temp.getNext() == trailer & i < index ){
                    //System.out.println("the list is short");
                    RuntimeException Runtime = new RuntimeException();
                    throw Runtime;
                }
                else {
                    return temp.getElement();
                }
            }
            else {
                NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
            }
        }
    }
    /**
     * check if set s is subset of set u
     * @param s the first set as array of strings
     * @param u the second set as array of strings
     * @return true if sis subset of u and false if not
     */
    private boolean IsSubset(String[] s,String[] u){
        //check if it is a subset of the universe
        if (u.length==1&&u[0]==""){
            return false;
        }
        if (s.length==1&&s[0].isEmpty()){
           return true;
        }
        else {
            for (String c : s) {
                boolean exist = false;
                for (String x : u) {
                    //it does not matter if the two strings have lower or upper case letters
                    if ((c.toLowerCase()).equals((x.toLowerCase()))) {
                        exist = true;
                        break;
                    }
                }
                if (exist == false) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * @param n number of sets
     * @param u the string of the universe
     */
    @Override
    public void ReadSetsAndStoreThem(int n, String u){
        String[] uni=StringToArrString(u);
        union=noDuplicates(uni);
        doubleLinkedList sets = new doubleLinkedList();
        for (int i=0;i<n;i++){
            String s;
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter the set number "+(i+1));
            s = scanner.nextLine();
            String[] strings= StringToArrString(s);
            if (IsSubset(strings,union)){
                sets.add(noDuplicates(strings));
            }
            else {
                System.out.println("that set is not subset of the Univers!");
                i--;
            }
        }
        this.sets=sets;
        //return sets;
    }
    /**
     * change the Array To DoubleLinkedList
     * @param o the Array
     * @return the DoubleLinkedList
     */
    private doubleLinkedList ArrayToDoubleLinkedList(Object[] o){
        doubleLinkedList dlist=new doubleLinkedList();
        for (Object x : o){
            dlist.add(x);
        }
        return dlist;
    }

    /**
     * change the DoubleLinkedList To Array
     * @param d the DoubleLinkedList
     * @return the Array
     */
    private Object[] DoubleLinkedListToArray(doubleLinkedList d){
        Object[] arr = new Object[d.size];
        boolean entered=false;
        for(int i=0;i<d.size;i++){
            if (!((String)(d.get(i+1))).isEmpty()) {
                arr[i] = d.get(i + 1);
                entered=true;
            }
        }
        if (entered=false){
            arr[0]="";
        }
        return arr;
    }
    /**
     * prints the UnionOfTwoSets
     * @param s1 first set as an array of string
     * @param s2 second set as an array of string
     */
    @Override
    public void UnionOfTwoSets(String[] s1,String[] s2){
        String[] union;
        if (s1.length==1&&s1[0].isEmpty()&&s2.length==1&&s1[0].isEmpty()){
            union=new String[0];
        }
        else if (s1.length==1&&s1[0].isEmpty()){
            union=s2;
        }
        else if (s2.length==1&&s1[0].isEmpty()){
            union=s1;
        }
        else {
            union = s1;
            for (String s : s2) {
                String[] temp = {s};
                if (!IsSubset(temp, union)) {
                    doubleLinkedList tempo = ArrayToDoubleLinkedList(union);
                    tempo.add(s);
                    union = Arrays.copyOf(DoubleLinkedListToArray(tempo), DoubleLinkedListToArray(tempo).length, String[].class);
                }
            }
        }
        System.out.println(Arrays.toString(union));
    }
    /**
     * prints the IntersectionOfTwoSets
     * @param s1 first set as an array of string
     * @param s2 second set as an array of string
     */
    @Override
    public void IntersectionOfTwoSets(String[] s1,String[] s2){
        String[] intersection={};
        if (s1.length==1&&s1[0].isEmpty()||s2.length==1&&s1[0].isEmpty()){
            intersection=new String[0];
        }
        else {
            for (String s : s1) {
                String[] temp = {s};
                if (IsSubset(temp, s2)) {
                    doubleLinkedList tempo = ArrayToDoubleLinkedList(intersection);
                    tempo.add(s);
                    intersection = Arrays.copyOf(DoubleLinkedListToArray(tempo), DoubleLinkedListToArray(tempo).length, String[].class);
                }
            }
        }
        System.out.println(Arrays.toString(intersection));
    }
    /**
     * prints the ComplementOfASet
     * @param s1 the set as an array of string
     * @param u  the universe set as an array of string
     */
    @Override
    public void ComplementOfASet(String[] s1,String[] u){
        String[] complement={};
        for (String s : u){
            String[] temp={s};
            if (!IsSubset(temp,s1)){
                doubleLinkedList tempo=ArrayToDoubleLinkedList(complement);
                tempo.add(s);
                complement= Arrays.copyOf(DoubleLinkedListToArray(tempo),DoubleLinkedListToArray(tempo).length,String[].class);
            }
        }
        System.out.println(Arrays.toString(complement));
    }

    /**
     * the execution of the operators of the set operations
     * @param n the choice of the menu
     */
    @Override
    public void execution(int n){
        Scanner scanner = new Scanner(System.in);
        int s1=0,s2=0;
        boolean stop;
        switch (n){
            case 1:
                stop=false;
                while (!stop) {
                    stop=true;
                    System.out.println("please enter the first set number of the subsets (e.g:1,2,...)");
                    s1 = scanner.nextInt();
                    if (s1 > sets.size) {
                        stop = false;
                        System.out.println("that number is greater than the number of all subsets");
                    }
                }
                stop=false;
                while (!stop) {
                    stop=true;
                    System.out.println("please enter the second set number of the subsets (e.g:1,2,...)");
                    s2 = scanner.nextInt();
                    if (s2> sets.size){
                        stop=false;
                        System.out.println("that number is greater than the number of all subsets");
                    }
                }
                UnionOfTwoSets((String[])(sets.get(s1)),(String[])(sets.get(s2)));
                break;
            case 2:
                stop=false;
                while (!stop) {
                    stop=true;
                    System.out.println("please enter the first set number of the subsets (e.g:1,2,...)");
                    s1 = scanner.nextInt();
                    if (s1 > sets.size) {
                        stop = false;
                        System.out.println("that number is greater than the number of all subsets");
                    }
                }
                stop=false;
                while (!stop) {
                    stop=true;
                    System.out.println("please enter the second set number of the subsets (e.g:1,2,...)");
                    s2 = scanner.nextInt();
                    if (s2> sets.size){
                        stop=false;
                        System.out.println("that number is greater than the number of all subsets");
                    }
                }
                IntersectionOfTwoSets((String[])(sets.get(s1)),(String[])(sets.get(s2)));
                break;
            case 3:
                stop=false;
                while (!stop) {
                    stop=true;
                    System.out.println("please enter the first set number of the subsets (e.g:1,2,...)");
                    s1 = scanner.nextInt();
                    if (s1> sets.size){
                        stop=false;
                        System.out.println("that number is greater than the number of all subsets");
                    }
                }
                ComplementOfASet((String[])(sets.get(s1)),union);
                break;
            default:
                System.out.println("there is no option of that number.");
        }
    }
}
