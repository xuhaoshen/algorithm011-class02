学习笔记
在第八周中，学习了位运算、布隆过滤器、LRU缓存以及常用的排序算法。
```
public class SortDemo {

  /**
   * 插入排序
   */
  public static int[] insertSort(int[] arr) {
    for(int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int temp = arr[i];
      for(;j>=0&&temp<arr[j];j--){ 
        arr[j + 1] = arr[j];
      }
      arr[j + 1] = temp;
    }
    return arr;
  }

  /**
   * 选择排序
   * @param arr
   * @return
   */
  public static int[] selectSort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      int j = i + 1;
      int position = i;
      int temp = arr[i];
      for(;j < arr.length; j++) {
        if(arr[j] < temp) {
          temp = arr[j];
          position = j;
        }
      }
      arr[position] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }

  /**
   * 冒泡排序
   * @param arr
   * @return
   */
  public static void bubbleSort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      for(int j = i+ 1; j < arr.length; j++) {
        if(arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
//    return arr;
  }

  /**
   * 快速排序
   */
  public static int partition(int[] arr, int low, int high) {
    int key = arr[low];
    while(low < high) {
      while(arr[high] >= key && low < high) {
        high--;
      }
      arr[low] = arr[high];
      while(arr[low] <= key && low < high) {
        low++;
      }
      arr[high] = arr[low];
    }
    arr[high] = key;
    return high;
  }

  public static void quickSort(int[] arr, int low, int high) {
    if(low >= high) return;
    int index = partition(arr, low, high);
    quickSort(arr, low, index - 1);
    quickSort(arr, index + 1, high);
  }
}
```