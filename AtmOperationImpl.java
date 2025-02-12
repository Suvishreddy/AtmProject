package sai;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AtmOperationImpl implements AtmOperationInterf {
	
	Atm atm=new Atm();
	Map<Double,String> ministmt=new HashMap<>();
	
	public void viewBalance() {
		
		System.out.println("Available Balance is: " +atm.getBalance());
	}

	public void withdrawAmount(double withdrawAmount) {
		
//		if(withdrawAmount%500==0)
//		{
			if(withdrawAmount<=atm.getBalance())
			{
				ministmt.put(withdrawAmount,"Amount withdrawn");
				System.out.println("Collected the cash of Rs:-" +  withdrawAmount);
				atm.setBalance(atm.getBalance()-withdrawAmount);
				viewBalance();
			}
			else
			{
				System.out.println("Insufficient Balance!");
			}
		}
//		else
//		{
//			System.out.println("please enter the amount in multiple of 500");
//		}
//		
//	}

	
	public void depositAmount(double depositAmount){
		
		ministmt.put(depositAmount,"Amount Deposited");
		System.out.println("Rs:-" + depositAmount + " Deposited Succesfully!");
		atm.setBalance(atm.getBalance()+depositAmount);
		viewBalance();
	}

	
	public void viewMiniStatement() {
		
//		for(Map.Entry<Double,String>m:ministmt.entrySet())
//		{
//			System.out.println(m.getKey()+""+m.getValue()); 
//		}
		Set<Double> set=ministmt.keySet();
		for(Double d:set) {
		
			System.out.println(d+"="+ministmt.get(d));
		}
	}

}
