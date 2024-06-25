package com.omrbranch.payloadobjectmanager;

import com.omrbranch.payload.AddressPayload;
import com.omrbranch.payload.ProductLoad;

public class PayLoadManager {
    private AddressPayload addressPayload;
    private ProductLoad productLoad;

    public AddressPayload getAddressPayload () {
        return (addressPayload == null) ? addressPayload = new AddressPayload () : addressPayload;
    }

    public ProductLoad getProductLoad () {
        return (productLoad == null) ? productLoad = new ProductLoad () : productLoad;
    }
}