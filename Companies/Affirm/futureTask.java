import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.Executors;

// you can add other public classes to this editor in any order
public class Solution {
  public static void main(String args[]) {
      int[] array = new int[]{1,2,3,4,5,6,7};
      List<Callable<Integer>> callables = new ArrayList<>();

      int numOfThreads = 2;
      int partSize = (int)Math.ceil((double)array.length / numOfThreads);
      int sum = 0;
      for (int i = 0; i < array.length; i += partSize) {
        callables.add(new SumArrayCallable(Arrays.copyOfRange(array, i, Math.min(i + partSize, array.length))));
      }
      ExecutorService executorService = ExecutorService.newFixedThreadPool(numOfThreads);
    
      try {
        List<Future<Integer>> futures = executorService.invokeAll(callables);

        for (Future<Integer> future : futures) {
          sum += future.get();
        }

        executorService.shutdown();
        System.out.println(sum);
      } catch (Exception e) {
        
      }
  }
}
class SumArrayCallable implements Callable<Integer> {
    private int[] array;
    public SumArrayCallable(int[] array) {
      this.array = array;
    }
    @Override
    public Integer call() throws Exception {
      int sum = 0;
      for (int i : array) {
        sum += i;
      }
      return sum;
    }
  }