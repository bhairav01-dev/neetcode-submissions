class Solution {

    public String encode(List<String> strs) {
        //e.g. abc, xyz, pqr => #3#abc#3#xyz#3#pqr
        //find size, delimate size and append followed by string
        StringBuilder sb = new StringBuilder();
        for(String x: strs){
            int len = x.length();
            sb.append("#"+len+"#").append(x);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int l = str.length();
        List<String> answer = new ArrayList<>();
        int i=0;
        while(i < l){
            int j=i+1;
            int sz =0;
            boolean done = false;
            while(j<l){
                if(str.charAt(j) == '#'){j++; done =true; break;}
                sz = sz*10+ (str.charAt(j)-'0');
                j++;
            }
            if(done){
                String result="";
                while(sz>0){
                    result += str.charAt(j);
                    j++;
                    sz--;
                }
                answer.add(result);
            }
            i=j;
        }
        return answer;
    }
}
