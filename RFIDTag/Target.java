
public class Target extends RFID{
	private Target head;
	private Target next;
	public void insert(Target target) {
		if(head ==null) {
			head = target;
		}else {
		insertTarget(head,target);
		}
	}
	public void insertTarget(Target head,Target target) {
		if(head.getID().equals(target.getID())) {
			head.setRssi(target.getRssi());
			head.setIdentifiedTime(target.getIdentifiedTime());
		}else {
		if(head.next == null) {
			head.next = target;
			return;
		}else {
			insertTarget(head.next,target);
		}
		}
	}
	public void view() {
		if(head==null) {
			System.out.println("�����Ͱ� ������ϴ�.");
		}else {
			viewReference(head);
		}
	}
	public void viewReference(Target target) {
		if(target==null) {
			return;
		}else {
		System.out.println(" �±� ���̵� : "+target.getID()+" �±� RSSI�� ��� :"+target.getRssi()+"  �±� RSSI�� ǥ�� ���� : "+target.getDeviation()+" ��� �ν� ���͹� : "+target.getTime()+" �ν� Ƚ�� : "+target.getCount());
		viewReference(target.next);
		}
	}
	public void positionKNN(Reference reference,int n) {
		if(head==null) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}else {
			setPositionKNN(reference,n,head);
		}
	}
	public void setPositionKNN(Reference reference,int n,Target target) {
		if(target==null) {
			return;
		}else {
			reference.predictionKNN(target, n);
			System.out.println(" �±� ���̵� : "+target.getID()+" �±� RSSI�� ��� :"+target.getRssi()+"  �±� RSSI�� ǥ�� ���� : "+target.getDeviation()+" ��� �ν� ���͹� : "+target.getTime()+" �ν� Ƚ�� : "+target.getCount()+" ��ǥ : ("+target.getX()+","+target.getY()+")");
			setPositionKNN(reference,n,target.next);
		}
	}
	public void positionGNN(Reference reference,int n) {
		if(head==null) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}else {
			setPositionGNN(reference,n,head);
		}
	}
	public void setPositionGNN(Reference reference,int n,Target target) {
		if(target==null) {
			return;
		}else {
			reference.predictionGNN(target, n);
			System.out.println(" �±� ���̵� : "+target.getID()+" �±� RSSI�� ��� :"+target.getRssi()+"  �±� RSSI�� ǥ�� ���� : "+target.getDeviation()+" ��� �ν� ���͹� : "+target.getTime()+" �ν� Ƚ�� : "+target.getCount()+" ��ǥ : ("+target.getX()+","+target.getY()+")");
			setPositionGNN(reference,n,target.next);
		}
	}
}
