import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "additional_options")
public class AdditionalOption {
    @Column(name = "option_id")
    private int optionID;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
}
