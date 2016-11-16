package graphics.graphics.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Size {

    private int x;
    private int y;

    public Size div(int div) {
        return new Size(x /= div, y /= div);
    }
}
