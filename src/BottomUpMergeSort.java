public class BottomUpMergeSort implements SortAlgorithm{
    public String getName() { return "Merge Sort Bottom UP"; }
    public void sort(SortArray arr) {
        Item[] temp = new Item[arr.size()];
        mergeSort(arr, temp, 0, arr.size()-1);
        // TODO: write merge sort here (add helper methods below)

    }
    public void mergeSort(SortArray arr, Item[] temp, int lo1, int hi1){
        for(int size=1; size<arr.size(); size*=2){
            for(int lo=0; lo<arr.size()-size; lo=lo+2*size){
                int mid = lo+size-1;
                int hi=Math.min(lo+2*size-1, arr.size()-1);
                merge(arr, temp, lo, mid, hi);
            }
        }
    }
    private void merge(SortArray arr, Item[] temp, int lo, int mid, int hi){
        for(int k=lo; k<=hi; k++){
            temp[k]=arr.get(k);
        }
        int i=lo;
        int j=mid+1;
        for(int k=lo; k<=hi; k++){

            if(i>mid){
                arr.set(k, temp[j]);
                j++;
            }
            else if(j>hi){
                arr.set(k, temp[i]);
                i++;
            }
            else if(arr.less(temp[i],temp[j])){
                arr.set(k, temp[i]);
                i++;
            }
            else if(arr.less(temp[j],temp[i])){
                arr.set(k, temp[j]);
                j++;
            }
            else if(!arr.less(temp[j],temp[i])&&!arr.less(temp[i],temp[j])){
                arr.set(k, temp[i]);
                i++;
            }
        }
    }
    public static void main(String[] args) {

    }
}
