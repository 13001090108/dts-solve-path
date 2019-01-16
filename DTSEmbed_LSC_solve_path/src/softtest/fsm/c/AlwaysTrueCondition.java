package softtest.fsm.c;

import org.w3c.dom.Node;
import softtest.cfg.c.*;

/** 
���û�й��������������������Զ����true��
������ڹ������������򷵻ع������������ķ���ֵ��
 */
public class AlwaysTrueCondition extends FSMCondition {

	/** ���������м��㣬�ж����Ƿ����� */
	@Override
	public boolean evaluate(FSMMachineInstance fsm, FSMStateInstance state,
			VexNode vex) {
		boolean b = true;
		if (relatedmethod == null) {
			b = true;
		} else {
			Object[] args = new Object[2];
			args[0] = vex;
			args[1] = fsm;
			try {
				Object obj = relatedmethod.invoke(null, args);
				if(obj instanceof Boolean)
				{
					b = (Boolean)obj;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("action error",e);
			}
		}
		return b;
	}

	/** ����xml */
	@Override
	public void loadXML(Node n) {
		if (fsm != null && fsm.getRelatedClass() != null) {
			loadAction(n, fsm.getRelatedClass());
		}
	}
}