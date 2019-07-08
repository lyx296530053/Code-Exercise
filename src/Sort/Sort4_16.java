package Sort;

public class Sort4_16 {
    public static void insertSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int value=arr[i];
            for(;j>=0;j--){
                if(arr[j]>value){
                    arr[j+1]=arr[j];
                }else
                    break;
            }
            arr[j+1]=value;
        }
    }
    public static void binarySort(int[] arr){
        int low,hight,mid,j;
        for(int i=1;i<arr.length;i++){
            low=0;
            hight=i-1;
            int value=arr[i];
            while(low<=hight){
                mid=(low+hight)/2;
                if(arr[mid]>value){
                    hight=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for(j=i-1;j>hight;j--){
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
                int j=i-step;
                int value=arr[i];
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
        int mid=(low+high)/2;
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
        while (start<=end){
            temp[k++]=arr[start++];
        }
        for(i=0;i<=high-low;i++){
            arr[low+i]=temp[i];
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low>=high)return;
        int q=doubleSign(arr,low,high);
        quickSort(arr,low,q-1);
        quickSort(arr,q+1,high);
    }
    public static int sign(int[] arr,int low,int high){
        int value=arr[low];
        int j=low;
        for (int i=low+1;i<=high;i++){
            if(arr[i]<value){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,low,j);
        return j;
    }
    public static int doubleSign(int[] arr,int low,int high){
        int i=low+1;
        int lt=low;
        int j=high;
        int value=arr[low];
        while(true){
            while (i<=high&&arr[i]<value)i++;
            while (j>=low&&arr[j]>value)j--;
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
    public static void threeSign(int[] arr,int low,int high){
        if(low>=high)return;
        int value=arr[low];
        int i=low+1;
        int lt=low;
        int gt=high+1;
        while (i<gt){
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
    public static void swap(int[] arr,int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
}
