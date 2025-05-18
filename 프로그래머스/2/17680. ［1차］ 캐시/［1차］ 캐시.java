import java.util.*;

class Solution {
    
   private List<String> cache = new ArrayList<>();
    
   public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return 5 * cities.length;

        cities = toLowerCaseArr(cities);

        for(String city : cities)
        {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;

            } else {

                if (cacheSize == cache.size())
                    cache.remove(0);

                answer += 5;
                cache.add(city);
            }

        }

        return answer;
    }

    private String[] toLowerCaseArr(String[] cities)
    {
        for(int i=0; i<cities.length; i++)
        {
            cities[i] = cities[i].toLowerCase();
        }

        return cities;
    }
    
}