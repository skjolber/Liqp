package liqp.nodes;

import liqp.LValue;
import liqp.TemplateContext;

class LtNode extends LValue implements LNode {

    private LNode lhs;
    private LNode rhs;

    public LtNode(LNode lhs, LNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Object render(TemplateContext context) {

        Object a = lhs.render(context);
        Object b = rhs.render(context);

        return (a instanceof Number) && (b instanceof Number) &&
                super.asNumber(a).doubleValue() < super.asNumber(b).doubleValue();
    }
}
