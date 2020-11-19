/*
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2020 Ruhr University Bochum, Paderborn University,
 * and Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package de.rub.nds.asn1.model;

import de.rub.nds.asn1.Asn1Encodable;
import de.rub.nds.asn1.TagClass;
import de.rub.nds.asn1.serializer.Asn1ExplicitSerializer;
import de.rub.nds.asn1.serializer.Asn1Serializer;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class Asn1Explicit extends Asn1Container {

    public static final int TAG_CLASS = TagClass.CONTEXT_SPECIFIC.getIntValue();

    public static final boolean IS_CONSTRUCTED = true;

    @XmlElement(name = "offset")
    private int offset = 0;

    @XmlAnyElement(lax = true)
    private List<Asn1Encodable> children = new LinkedList<>();

    public Asn1Explicit() {
        super(TAG_CLASS, IS_CONSTRUCTED, 0);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public void addChild(final Asn1Encodable child) {
        this.children.add(child);
    }

    @Override
    public List<Asn1Encodable> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Asn1Encodable> children) {
        this.children = children;
    }

    @Override
    public void clearChildren() {
        this.children.clear();
    }

    @Override
    public Asn1Serializer getSerializer() {
        return new Asn1ExplicitSerializer(this);
    }
}
