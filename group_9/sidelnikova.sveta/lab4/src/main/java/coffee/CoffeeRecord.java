package coffee;

public record CoffeeRecord(CoffeeSort sort, String country, String farm, ProcessingType processingType,
                           double heightOfGrowth) {
}
