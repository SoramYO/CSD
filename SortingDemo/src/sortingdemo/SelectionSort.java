
package sortingdemo;


public class SelectionSort {
    public static void selectionSort(int[] a){
        int n = a.length;
        for(int i = 0; i< n-1;i++){
            int minIdx = i;//cho so dau tine cua mang chua duoc sort
            int minVal = Integer.MAX_VALUE;;
            //tim phan tu nho nhat cua mang chua duoc sort
            for(int j = i;j<n;j++){
                if(a[j] < minVal){
                    minIdx=j;
                    minVal= a[j];
                }
            }
            //swap phan tu nho nhat voi phan tu dau tien cua mag chua duoc sort
            if(minIdx!=i){
                int temp = a[minIdx];
                a[minIdx] = a[i];
                a[i] = temp;
            }
        }
    }
     
    public static void main(String[] args) {
        int [] a ={15,8,10,2,5};
        selectionSort(a);
        for(int x: a){
            System.out.print(x+",");
        }
    }
    
}
