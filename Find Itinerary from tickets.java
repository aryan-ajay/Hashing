Find Itinerary from tickets 

  
  public class Ajay {
  public static String getStarting(HashMap<String, String> tickets) { //<from, to>
        HashMap<String, String> revMap = new HashMap<>(); // it reverse map it meand <to, from>

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
  public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStarting(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()) {
            System.out.print("-> "+ tickets.get(start));
            start = tickets.get(start);
        }
    }
}
