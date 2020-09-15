package NLL;

public class DataSet {
	ReadExcel librarian;
	private double [][] mapa = new double[4][4];
	private item [] itemList;
	private double[] itemsWeight = new double[5];
	private double[] itemsProfit = new double[5];
	private int[] cityOfItems = new int[5];
	
	public DataSet() {
		this.mapa = librarian.read("F:\\Github\\gecco19-thief\\TTPMap.xlsx");
		this.itemList = librarian.readItems("F:\\Github\\gecco19-thief\\TTPMap.xlsx");
		this.setItemsProfit(itemList);
		this.setItemsWeight(itemList);
		this.setCityOfItems(itemList);
	}
	

	/**
	 * @return the mapa
	 */
	public double[][] getMapa() {
		return mapa;
	}

	/**
	 * @param mapa the mapa to set
	 */
	public void setMapa(double[][] mapa) {
		this.mapa = mapa;
	}

	/**
	 * @return the itemList
	 */
	public item[] getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(item[] itemList) {
		this.itemList = itemList;
	}


	/**
	 * @return the itemsProfit
	 */
	public double[] getItemsProfit() {
		return itemsProfit;
	}


	/**
	 * @param itemsProfit the itemsProfit to set
	 */
	public void setItemsProfit(item[] itemList) {
		for(int i=0; i<itemList.length;i++) {
			this.itemsProfit[i] = itemList[i].getProfit();
		}
	}


	/**
	 * @return the itemsWeight
	 */
	public double[] getItemsWeight() {
		return itemsWeight;
	}


	/**
	 * @param itemsWeight the itemsWeight to set
	 */
	public void setItemsWeight(item[] itemList) {
		for(int i=0; i<itemList.length;i++) {
			this.itemsWeight[i] = itemList[i].getWeight();
		}
	}
	
	/**
	 * @return the cityOfItems
	 */
	public int[] getCityOfItems() {
		return cityOfItems;
	}


	/**
	 * @param itemList is the parameter for getting itemsweight
	 */
	public void setCityOfItems(item[] itemList) {
		for(int i=0; i<itemList.length; i++) {
			this.cityOfItems[i] = itemList[i].getCityId();
		}
		
	}
	
	
}
