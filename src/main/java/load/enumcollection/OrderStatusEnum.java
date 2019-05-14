package load.enumcollection;

public enum OrderStatusEnum {

    NEW_ORDER(1),CANCEL_ORDER(2),SHIPPED_ORDER(3),RECEIWED_ORDER(4),FINISH_ORDER(5);

    /**
     * 1
     */
    private int order;

    OrderStatusEnum(int order){
        this.order=order;
    }

    public void setOrder(int order){
        this.order=order;
    }

    public int getOrder(){
        return order;
    }
}
