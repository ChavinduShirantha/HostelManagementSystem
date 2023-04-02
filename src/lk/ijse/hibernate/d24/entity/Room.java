package lk.ijse.hibernate.d24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:24 AM
 **/
@Entity
@Table(name = "room")
public class Room implements SuperEntity{
    @Id
    @Column(name = "room_type_id")
    private String r_id;
    @Column(name = "type")
    private String r_type;
    @Column(name = "key_money")
    private String key_money;
    @Column(name = "qty")
    private int qty;

    public Room() {
    }

    public Room(String r_id, String r_type, String key_money, int qty) {
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
        return "Room{" +
                "r_id='" + r_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
