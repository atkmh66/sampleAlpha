
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountEachWords {

    // Static method to read in a file and load the class member variable "wordMap"
    // Locally this map is known as myWordsMap
    static void CountWords(String filename, Map< String, Integer> myWordsMap)  throws FileNotFoundException {
            Scanner file=new Scanner (new File(filename));
            int fileRecCount=0;
            long startTime = System.nanoTime();
            //long startTime = System.currentTimeMillis();
            while(file.hasNext()){
                fileRecCount++;
                String inputWord = file.next();
                Integer count = myWordsMap.get(inputWord);
                if(count != null)
                    count++;
                else
                    count=1;
                //debug: System.out.println("word putting back with count: " +word +" " +count);
                myWordsMap.put(inputWord,count);
            }
            long endTime = System.nanoTime();
            //long endTime = System.currentTimeMillis();
            file.close();
            long duration = ( endTime - startTime)/1000000;
            System.out.println("load Map duration === " + duration + " miliseconds for " +fileRecCount +" records in file");

        }


        //public static void myPublicStaticOutPrintlnMap(Map inputMap){
    public static void mapPrintLnByKeySort(Map inputMap){
           // Instanciate something that is sortabblej
       long treeMapDeclarationStart = System.nanoTime();
       TreeMap<String, Integer> localSortedTreeMap = new TreeMap<>();
       long treeMapDeclarationStop = System.nanoTime();


        long treeMapCopyStart = System.nanoTime();
        // copy all the inputdata to the sortable objecgt
       localSortedTreeMap.putAll(inputMap);
        long treeMapCopyStop = System.nanoTime();

        long TM_Declare = (treeMapDeclarationStop - treeMapDeclarationStart);
        System.out.println("TreeMapDeclaration in nanos : " +TM_Declare);
        long TM_Copy = (treeMapCopyStop - treeMapCopyStart);
        System.out.println("TreeMapCopy in nanos : " +TM_Copy);
       //now the Output portion
       for(Map.Entry<String, Integer> outPutVar : localSortedTreeMap.entrySet()){
            System.out.println(outPutVar.getKey() + " " +outPutVar.getValue() );
                //System.out.println(outPutVar.getValue() + " " +outPutVar.getKey() );
            }
       }

        //public static HashMap<String, Integer> PrintHashMapByValue(HashMap<String,Integer> myHashMap){
        public static void PrintHashMapByValue(HashMap<String,Integer> myHashMap){

            // Create a list from elements of HashMap. Single Statement declaration for myLocalList
            long newLinkedListStart = System.nanoTime();
            List<Map.Entry<String, Integer> > myLocalList =
                    new LinkedList<Map.Entry<String, Integer > >(myHashMap.entrySet());
            long newLinkedListStop = System.nanoTime();

            long collection_SortStart = System.nanoTime();
            // Sort this newly created list named myLocalList
            Collections.sort(myLocalList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> myObj1,
                                   Map.Entry<String, Integer> myObj2){
                    return (myObj1.getValue()).compareTo(myObj2.getValue());
                }//end of Local compare
            }); //end of Collections.sort

            // transfer the sorted List data backinto a hashMap
            //  First Declare the return variable
            HashMap<String,Integer> tempReturnMap = new LinkedHashMap<String, Integer>();
            //  Second do the transfer
            for (Map.Entry<String, Integer>  accessThing : myLocalList ){
                tempReturnMap.put(accessThing.getKey(), accessThing.getValue());

            } // end transfer for loop
            long collection_SortStop = System.nanoTime();

            // No longer returning a map.  we are printing it out here.
            //return tempReturnMap;

            long printValueSortStart  = System.nanoTime();
             for(Map.Entry<String, Integer> outThing : tempReturnMap.entrySet() ){
                 System.out.println(outThing.getKey() +" " + outThing.getValue() );
             }  // end forloop System.Out.Pringln blablabla
            long printValueSortStop  = System.nanoTime();

             long newLinkedListDuration = (newLinkedListStop - newLinkedListStart );
             long collectdionSortDuration = (collection_SortStop - collection_SortStart ); //1000000;
             System.out.println("NewLinkedList create duration in nanos " + newLinkedListDuration);
             System.out.println("Sort list by value duration in nanos " +collectdionSortDuration);
       }// end of PRingHashMayByValue


        public static void main(String[] args)
        {
            System.out.println("Path to where input file is expected.");
            System.out.println(new File("inputTestData.txt").getAbsolutePath());
            //Map<String,Integer> wordMap=new HashMap<String, Integer>();
            HashMap<String,Integer> wordMap=new HashMap<String, Integer>();
            try {
                CountWords("inputTestData.txt", wordMap);
            }
            catch (Exception e) {
                System.out.println("well we experience a CountWords exception");
            }
            //System.out.println(wordMap);
            //System.out.println(Arrays.asList(wordMap));
            //System.out.println(Collections.singletonList(wordMap));
//            for (Map.Entry<String, Integer> testVar : wordMap.entrySet()){
//               System.out.println( testVar.getKey() +"->" + testVar.getValue());
//               // System.out.println( testVar.getValue() +"->" + testVar.getKey());
//
//            }
            System.out.println("Sorted by Value`");
            PrintHashMapByValue(wordMap);
            System.out.println("Sorted by Key");
            mapPrintLnByKeySort(wordMap);
        }
    }
