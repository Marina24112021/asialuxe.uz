package api.models.bookTicket.components;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaOfOrderComponent {
    private Integer totalCount,
            pageCount,
            currentPage,
            perPage;
}
