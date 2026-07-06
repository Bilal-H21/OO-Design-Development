package lib;

public class OrderLine {
	
	//Fields
	private String Id;
	private int UnitPrice;
	private int Quantity;
	
	//Constructors
	public OrderLine() {
		Id = "";
		UnitPrice = 0;
		Quantity = 0;
	}
	
	public OrderLine(String Id) {
		this.Id = "";
		UnitPrice = 0;
		Quantity = 0;
	}
	
	
	public OrderLine(String Id, int UnitPrice, int Quantity) {
		this.Id = Id;
		this.UnitPrice = UnitPrice;
		if (Quantity < 0) {
			this.Quantity = 0;
		} else {
			this.Quantity = Quantity;
		}
	}
	
	//Methods
	public String getId() {
		return Id;
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public int getUnitPrice() {
		return UnitPrice;
	}
	
	public void setUnitPrice(int UnitPrice) {
		this.UnitPrice = UnitPrice;
	}
	
	public int getQuantity( ) {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		if (Quantity >= 0) {
			this.UnitPrice = Quantity;
		}
	}
		
		public int getCost() {
			return UnitPrice * Quantity;
		}

		public String toString() {
			return "OrderLine:[id=" + Id + ", UnitPrice=" + UnitPrice 
					+ ", Quantity=" + Quantity + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			return (obj instanceof OrderLine other)
					&& this.Id.equals(other.Id)
					&& this.UnitPrice == other.UnitPrice
					&& this.Quantity == other.Quantity;
		}
		
	}
	


