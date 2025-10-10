import java.util.*;

//요금표
//fees[0] - 기본시간
//fees[1] - 기본요금
//fees[2] - 단위시간
//fees[3] - 단위요금

//사용시간 > 기본시간
//기본요금 + [ (사용시간 - 기본시간) / 단위시간 ] * 단위요금

//사용시간 < 기본시간
//기본요금


//1. 입차시간, 출차시간를 차량 번호를 기준으로 담고, 분 단위로 담아야 할듯
//2. 분 단위로 담은 시간을 비교하여 요금계산

class Solution {
    
    static final int last_time = (23 * 60) + 59;
    
    Map<String, List<Integer>> in_map = new HashMap<>();
    Map<String, List<Integer>> out_map = new HashMap<>();
    Map<String, Integer> result_map = new HashMap<>();
        
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        for(String record : records)
        {
            String[] dev = record.split(" ");
            
            //1. 시간을 분단위로 변경
            int time = changeTime(dev[0]);
            
            List<Integer> timeList = null;
                        
            //2. 일단 담는다(in, out 구분)
            if(dev[2].equals("IN"))
            {
                if(in_map.containsKey(dev[1]))
                {
                    timeList = in_map.get(dev[1]);
                    timeList.add(time);
                    in_map.put(dev[1], timeList);
                }
                else{
                    timeList = new ArrayList<>();
                    timeList.add(time);
                    in_map.put(dev[1], timeList);
                }
            }
            else{
                if(out_map.containsKey(dev[1]))
                {
                    timeList = out_map.get(dev[1]);
                    timeList.add(time);
                    out_map.put(dev[1], timeList);
                }
                else{
                    timeList = new ArrayList<>();
                    timeList.add(time);
                    out_map.put(dev[1], timeList);
                }
            }
        }
            
        
        //3. 시간 계산, 요금 계산
        for(String key : in_map.keySet())
        {
            int used_time = 0;
            //4. 우선 in과 out이 같은지 비교, in이 많으면 last_time에서 마지막 in시간 빼야함
            if(out_map.containsKey(key))
            {
                int in_size = in_map.get(key).size();
                int out_size = out_map.get(key).size();
                used_time= calculateUsedTime(in_map.get(key),out_map.get(key));
                
                //아직 출차를 안했을 경우
                if(in_size > out_size)
                {
                    used_time += (last_time - in_map.get(key).get(in_size-1));
                }
                                              
            }
            else{
                used_time = last_time - in_map.get(key).get(0);
            }
    
            //4. 요금계산
            result_map.put(key,calculateFee(used_time, fees));
            
        }
            
        
        //5. 결과 출력
        List<String> keySet = new ArrayList<>(result_map.keySet());
        Collections.sort(keySet);
        answer = new int[keySet.size()];
        int i=0;
        
        for(String key : keySet)
        {
            answer[i] = result_map.get(key);
            i++;
        }
                      
        return answer;
    }
    
    private int changeTime(String strTime)
    {
        String[] devTime = strTime.split(":");
        int hour = Integer.parseInt(devTime[0]);
        int min = Integer.parseInt(devTime[1]);
        
        return (hour * 60) + min;
    }

    private int calculateUsedTime(List<Integer> in_list, List<Integer> out_list)
    {
        int used_time = 0;
        
        for(int i=0; i<out_list.size(); i++)
        {
            used_time += out_list.get(i) - in_list.get(i);
        }
            
        return used_time;
    }

    private int calculateFee(int used_time, int[] fees) {
        if (used_time > fees[0]) {
            double extraTime = used_time - fees[0];
            double unit = fees[2];
            int extraFee = (int) Math.ceil(extraTime / unit) * fees[3];
            return fees[1] + extraFee;
        } else {
            return fees[1];
        }
    }

}