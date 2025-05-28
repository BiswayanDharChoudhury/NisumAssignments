public class StoreIdPadder {
    public static String padStoreId(String storeId) {
        return String.format("%04d", Integer.parseInt(storeId));
    }

    public static void main(String[] args) {
        System.out.println(padStoreId("7"));    
        System.out.println(padStoreId("85"));   
        System.out.println(padStoreId("123"));  
        System.out.println(padStoreId("4567")); 
    }
}
