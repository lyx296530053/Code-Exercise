
package Sort;
class Sorts{
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void insertSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int value=arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(arr[j]>value){
                    arr[j+1]=arr[j];
                }else break;
            }
            arr[j+1]=value;
        }
    }
    public static void binarySort(int[] arr){
        int low,high,mid,j=0;
        for(int i=1;i<arr.length;i++){
            low=0;
            high=i-1;
            int value=arr[i];
            while(low<=high){
                mid=(low+high)/2;
                if(arr[mid]>value){
                 high=mid-1;
                }else {
                    low=mid+1;
                }
            }
            for(j=i-1;j>high;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=value;
        }
    }
    public static void shellSort(int[] arr){
        int n=arr.length;
        int step=n/2;
        while(step>=1){
            for(int i=step;i<n;i++){
                int value=arr[i];
                int j=i-step;
                for(;j>=0;j-=step){
                    if(arr[j]>value) {
                        arr[j + step] = arr[j];
                    }else break;
                }
                arr[j+step]=value;
            }
            step=step/2;
        }
    }
    public static void mergeSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int q=(low+high)/2;
        mergeSort(arr,low,q);
        mergeSort(arr,q+1,high);
        merge(arr,low,q,high);

    }
    public static void merge(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int []temp=new int[high-low+1];
        while(i<=mid&&j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        int start=i;
        int end=mid;
        if(high>=j){
            start=j;
            end=high;
        }
        while(start<=end){
            temp[k++]=arr[start++];
        }
        for( i=0;i<=high-low;i++){
            arr[i+low]=temp[i];
        }
    }
    public static void selectSort(int[] arr,int n){
        if(n <= 1) return;
      for(int i=0;i<n;i++){
          int min=i;
          for(int j=i+1;j<n;j++){
              if(arr[j]<arr[min]){
                  min=j;
              }
          }
          int temp=arr[i];
          arr[i]=arr[min];
          arr[min]=temp;
      }
    }
    public static void quickedSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int q=sign(arr,low,high);
        quickedSort(arr,low,q-1);
        quickedSort(arr,q+1,high);
    }
    public static int sign(int[] arr,int low,int high){
        int value=arr[low];
        int j=low;
        for(int i=low+1;i<=high;i++){
            if(arr[i]<value){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int[] arr,int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
}
public class SortTest {
    public static void main(String[] args) {
        int[] arr=new int[]{2,9,4,3,6,5,1,8,7,11};
        //Sorts.bubbleSort(arr);
        //Sorts.insertSort(arr);
        //Sorts.binarySort(arr);
        //Sorts.shellSort(arr);
        //Sorts.mergeSort(arr,0,9);
        Sorts.selectSort(arr,9);
        Sorts.quickedSort(arr,0,9);
        for (int i:arr
             ) {
            System.out.print(i+",");
        }

    }
}
