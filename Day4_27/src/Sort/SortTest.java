package Sort;

class Sort{
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
                }else{
                    break;
                }
            }
            arr[j+1]=value;
        }
    }
    public static void binaryInsort(int[] arr){
        int n=arr.length;
        int low,high,mid;
        for(int i=1;i<n;i++){
            int value=arr[i];
            low=0;
            high=i-1;
            int j=i-1;
            while(low<=high){
                mid=(low+high)/2;
                if(arr[mid]>value){
                   high=mid-1;
                }else {
                    low=mid+1;
                }
            }
            for(;j>high;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=value;
        }
    }
    public static void shellSort(int[] arr){
        int step=arr.length/2;
        while(step>=1){
            for(int i=step;i<arr.length;i++){
                int value=arr[i];
                int j=i-step;
                for(;j>=0;j-=step){
                    if(arr[j]>value){
                        arr[j+step]=arr[j];
                    }else {
                        break;
                    }
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
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int[] temp=new int[high-low+1];
        int k=0;
        while(i<=mid&&j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        int start=i;
        int end=mid;
        if(high>=j){
            start=j;
            end=high;
        }
        while (start<=end){
            temp[k++]=arr[start++];
        }
        for(i=0;i<=high-low;i++){
            arr[i+low]=temp[i];
        }
    }
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            int j=i+1;
            for(;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int q=doubleSign(arr,low,high);
        quickSort(arr,low,q-1);
        quickSort(arr,q+1,high);
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
    public static int doubleSign(int[] arr,int low,int high){
        int value=arr[low];
        int i=low+1;
        int j=high;
        while(true){
            while(i<high&&arr[i]<value)i++;
            while(j>low&&arr[j]>value)j--;
            if(i>=j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int[] arr,int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
    public static void threeSign(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int value=arr[low];
        int i=low+1;
        int gt=high+1;
        int lt=low;
        while(i<gt){
            if(arr[i]>value){
                swap(arr,i,gt-1);
                gt--;
            }else if(arr[i]<value){
                swap(arr,i,lt+1);{
                    i++;
                    lt++;
                }
            }else {
                i++;
            }
        }
        swap(arr,low,lt);
        threeSign(arr,low,lt);
        threeSign(arr,gt,high);

    }
}
public class SortTest {
    public static void main(String[] args) {
        int[] arr={3,5,2,1,9,7,6,4,8,55};
        Sort.bubbleSort(arr);
        Sort.insertSort(arr);
        Sort.binaryInsort(arr);
        Sort.shellSort(arr);
        Sort.mergeSort(arr,0,9);
        Sort.selectSort(arr);
        Sort.quickSort(arr,0,9);
        Sort.threeSign(arr,0,9);
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
