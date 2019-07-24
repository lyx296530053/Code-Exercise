package Sort;

/**
 * Created by lyx on 2019/4/3.
 */
public class Sort4_3 {
    public static void shellSort(int[] arr){
        int n=arr.length;
        int step=n/2;
        while(step>=1){
            for(int i=step;i<n;i++){
                int value=arr[i];
                int j=i-step;
                for(;j>=0;j-=step){
                    if(arr[j]>value){
                        arr[j+step]=arr[j];
                    }else
                        break;
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
        int mid=(high+low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int[] temp=new int[high-low+1];
        while(i<=mid&&j<=high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
            for(i=0;i<=high-low;i++){
                arr[low+i]=temp[i];
            }

    }
    public static void binarySort(int[] arr){
        int low,mid,high,j;
        for(int i=1;i<arr.length;i++){
            int value=arr[i];
            low=0;
            high=i-1;
            while(low<=high){
                mid=(low+high)/2;
                if(arr[mid]<value){
                    low=mid+1;
                }else
                    high=mid-1;
            }
            for(j=i-1;j>high;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=value;
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
            while(i<=high&&arr[i]<value)i++;
            while(j>=low&&arr[j]>value)j--;
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
    private static void swap(int[] arr,int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
    public static void threeSign(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int value=arr[low];
        int lt=low;
        int gt=high+1;
        int i=low+1;
        while(i<gt){
            if(arr[i]>value){
                swap(arr,i,gt-1);
                gt--;
            }else if(arr[i]<value){
                swap(arr,i,lt+1);
                i++;
                lt++;
            }else
                i++;
        }
        swap(arr,low,lt);
        threeSign(arr,low,lt);
        threeSign(arr,gt,high);
    }
}