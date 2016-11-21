package a1;



import com.tydic.hna.ConnectMgr;

public class test {
	
	
	public static void main(String[] args) {
		ConnectMgr connect = ConnectMgr.getInstance();
        connect.setSystemId(11);
        connect.setBingip("10.2.55.92");
        connect.setServiceAddress("http://10.72.23.169:9000");
        connect.setHpno("300000");
        connect.InitConnect(); //初始化B端
        String input ="<OPERATION_CODE>3</OPERATION_CODE><ACCESS_TYPE>3</ACCESS_TYPE><REQUEST_AMOUNT>1</REQUEST_AMOUNT><HPNO>300000</HPNO><PIN>123456</PIN><RECHARGE_ITEM><CARD_PIN>123456789000</CARD_PIN><SUB_ID></SUB_ID><DESTINATION_ID>13480919198</DESTINATION_ID><DESTINATION_ATTR>2</DESTINATION_ATTR><CUSER_NO></CUSER_NO><PAY_METHOD>5</PAY_METHOD></RECHARGE_ITEM>";
        StringBuilder request = new StringBuilder();
        connect.Send("Recharge", input, request);
        System.out.println("Return Value: " +  request.toString());
        return;
	}

}
