package common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotlineItems implements Comparable<HotlineItems> {

    private String title;
    private Integer price;

    @Override
    public int compareTo(HotlineItems anotherItem) {
        return this.price - anotherItem.price;
    }
}
