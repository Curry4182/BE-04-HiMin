package com.prgrms.himin.shop.api;

import com.prgrms.himin.shop.application.ShopService;
import com.prgrms.himin.shop.domain.Category;
import com.prgrms.himin.shop.dto.request.ShopCreateRequest;
import com.prgrms.himin.shop.dto.request.ShopUpdateRequest;
import com.prgrms.himin.shop.dto.response.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<ShopResponse> createShop(@Valid @RequestBody ShopCreateRequest request) {
        ShopResponse response = shopService.createShop(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<ShopResponse> getShop(@PathVariable Long shopId) {
        ShopResponse response = shopService.getShop(shopId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ShopResponse>> getShops(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer deliveryTip
    ) {
        List<ShopResponse> responses = shopService.getShops(
                name,
                category,
                address,
                deliveryTip
        );
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{shopId}")
    public ResponseEntity<Void> updateShop(
            @PathVariable Long shopId,
            @RequestBody ShopUpdateRequest.Info request
    ) {
        shopService.updateShop(shopId, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{shopId}")
    public ResponseEntity<Void> changeShopStatus(
            @PathVariable Long shopId,
            @RequestBody ShopUpdateRequest.Status request
    ) {
        shopService.changeShopStatus(shopId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long shopId) {
        shopService.deleteShop(shopId);
        return ResponseEntity.noContent().build();
    }
}
