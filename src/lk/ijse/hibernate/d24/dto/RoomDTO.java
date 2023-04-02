package lk.ijse.hibernate.d24.dto;


/**
 * @author : Chavindu
 * created : 4/2/2023-9:29 AM
 **/
public class RoomDTO {
    private String r_id;
    private String r_type;
    private String key_money;
    private int qty;

    public RoomDTO() {
    }

    public RoomDTO(String r_id, String r_type, String key_money, int qty) {
        this.r_id = r_id;
        this.r_type = r_type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getKey_money() {
        return key_money;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "r_id='" + r_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                '}';
    }
}
