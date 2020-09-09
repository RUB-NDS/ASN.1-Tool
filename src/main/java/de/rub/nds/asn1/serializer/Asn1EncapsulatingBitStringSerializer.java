package de.rub.nds.asn1.serializer;

import de.rub.nds.asn1.model.Asn1EncapsulatingBitString;
import de.rub.nds.util.ByteArrayUtils;


public class Asn1EncapsulatingBitStringSerializer extends Asn1FieldSerializer {

    private final Asn1EncapsulatingBitString asn1EncapsulatingBitString;

    public Asn1EncapsulatingBitStringSerializer(Asn1EncapsulatingBitString asn1EncapsulatingBitString) {
        super(asn1EncapsulatingBitString);
        this.asn1EncapsulatingBitString = asn1EncapsulatingBitString;
    }

    @Override
    public void updateLayers() {
        this.encodeEncapsulatingBitString();
        super.updateLayers();
    }

    private void encodeEncapsulatingBitString() {
        byte[] content = new byte[] { 0 }; // Number of unused bits is zero
        content = ByteArrayUtils.merge(content, this.asn1EncapsulatingBitString.getEncodedChildren());
        this.asn1EncapsulatingBitString.setContent(content);
    }
}