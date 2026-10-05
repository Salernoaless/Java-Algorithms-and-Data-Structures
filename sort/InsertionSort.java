
/**
 * @author Salernoaless
 * O(n^2) complexity in worst case,classic Insertion Sort
 * if the array it's already sorted O(n) since it recognizes it as it procedes
 * in place so 1 space complexity
 */
class InsertionSort{

    static void swap(int[] list,int i,int j){
        int support = list[i];
        list[i] = list[j];
        list[j] = support;
        return;
    }

    /**
     * this sorting algorithm works on the assumption that the subvector
     * located on the left side is always sorted so failing a comparison with the biggest
     * implies failing it with smaller elements allowing a break
     */
    static void sort(int[] list, int size){
        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j > 0;j--){
                if(list[j] < list[j-1]){
                    swap(list,j-1,j); //if the swaps go on it's similar to a bubble sort where 
                                    //the elements works its way into a sorted array
                                    //swapping one element at a time
                }else{
                    break; //it is possible to save a couple of cycles if one breaks when swap does not take place
                }
            }
        }
    }
}