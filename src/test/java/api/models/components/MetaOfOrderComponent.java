package api.models.components;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaOfOrderComponent {
    private Integer totalCount,
            pageCount,
            currentPage,
            perPage;
}
