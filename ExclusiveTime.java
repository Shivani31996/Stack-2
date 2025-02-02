public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null)
            return new int[0];
        
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(String log:logs)
        {
            String[] strArr = log.split(":");
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    int prevTask = st.peek();
                    result[prevTask] += curr - prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }
            else
            {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
