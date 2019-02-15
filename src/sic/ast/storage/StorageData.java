package sic.ast.storage;

import sic.asm.Location;
import sic.ast.data.Data;
import sic.ast.directives.Directive;
import sic.common.Mnemonic;

/**
 * TODO: write a short description
 *
 * @author jure
 */
public class StorageData extends Directive {

    public final Data data;             // data-initializer operand
    public final boolean isLiteral;     // was generated by literal

    public StorageData(Location loc, String label, Mnemonic mnemonic, Data data, boolean isLiteral) {
        super(loc, label, mnemonic);
        this.data = data;
        this.isLiteral = isLiteral;
    }

    public StorageData(Location loc, String label, Mnemonic mnemonic, Data data) {
        this(loc, label, mnemonic, data, false);
    }

    public boolean equals(StorageData that) {
        return data.equals(that.data);
    }

    @Override
    public String nameToString() {
        return (isLiteral ? "=" : "") + mnemonic.name;
    }

    @Override
    public String operandToString() {
        return data.toString();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void emitRawCode(byte[] data, int loc) {
        this.data.emit(data, loc);
    }

}