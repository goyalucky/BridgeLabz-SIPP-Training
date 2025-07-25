	import java.util.HashMap;
	public class frequency{
	    public static void main(String[] args){
	        int []arr={1,1,2,3,4,5,3,2,4,5,6,1};
	        HashMap<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<arr.length;i++){
	            if(map.containsKey(arr[i])){
	                int fre=map.get(arr[i]);
	                map.put(arr[i],fre+1);
	            }else
	            map.put(arr[i],1);
	        }
	
	        System.out.println(map);
	
	    }
	}
