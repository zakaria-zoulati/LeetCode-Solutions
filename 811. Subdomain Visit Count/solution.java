class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            String[] subdomains = domain.split("\\.");
            for (int i = subdomains.length - 1; i >= 0; i--) {
                StringBuilder subdomainBuilder = new StringBuilder();
                for (int j = i; j < subdomains.length; j++) {
                    subdomainBuilder.append(subdomains[j]);
                    if (j < subdomains.length - 1) {
                        subdomainBuilder.append('.');
                    }
                }
                String subdomain = subdomainBuilder.toString();
                countMap.put(subdomain, countMap.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            StringBuilder inter = new StringBuilder() ; 
            inter.append( entry.getValue()  ) ; 
            inter.append(" ") ; 
            inter.append( entry.getKey() ) ; 
            result.add(  inter.toString()  );
        }
        return result;
    }
}
