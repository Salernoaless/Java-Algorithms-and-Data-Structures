
/**
 * O(logn), efficient merge sort, recursive
 * O(n) space required
 * it is not an in-place algorithm
 */
public class MergeSort{
    static int[] extractArray(int[] list, int start, int end){
        
        //create an array of dimension end-beginning
        int[] extracted = new int[end-start];
        for(int i = 0; i <end -start;i++){
            extracted[i] = list[i+start]; 
        }
        return extracted;
    }



    static void merge(int[] list,int start,int center, int end){
        //i create two subarrays of size center and end-center and a slider for each
        int[] section_a = extractArray(list,start,center);
        int slide_a = 0;
        int[] section_b = extractArray(list,center,end);
        int slide_b = 0;
        int i = start;

        //it's important not to confuse length with position, to get the actual position you should use center-start etc.
        while(slide_a < center -start && slide_b < end-center){
            //while they have not run out of elements a comparison logic is used
            if(section_a[slide_a] <= section_b[slide_b]){
                list[i] = section_a[slide_a];
                slide_a++;
                i++;
            }else{
                list[i] = section_b[slide_b];
                slide_b++;
                i++;
            }
        }

       //the remaining elements are copied
        if(slide_a != center-start){
            for(; i < end;i++){
                list[i] = section_a[slide_a];
                slide_a++;
            }
        }else if(slide_b != end-center){
            for(; i < end;i++){
                list[i] = section_b[slide_b];
                slide_b++;
            }
        }



    }
    
    public static void sort(int[] list, int start, int end){
        if(start == end || end-start == 1){
            return;
        }
        //you need start + length of the half-array
        int center = start + (end-start)/2;
        // sorting of the two halves
        sort(list,start,center);
        sort(list,center,end);
        //merging
        merge(list,start,center,end);
        //the array is now sorted 
    }
}