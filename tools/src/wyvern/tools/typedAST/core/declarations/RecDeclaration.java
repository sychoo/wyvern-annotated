package wyvern.tools.typedAST.core.declarations;
import java.util.List;

import wyvern.target.corewyvernIL.decltype.DeclType;
import wyvern.target.corewyvernIL.modules.TypedModuleSpec;
import wyvern.target.corewyvernIL.support.GenContext;
import wyvern.tools.errors.FileLocation;
import wyvern.tools.typedAST.abs.Declaration;
import wyvern.tools.typedAST.interfaces.CoreAST;
import wyvern.tools.typedAST.interfaces.ExpressionAST;
import wyvern.tools.typedAST.interfaces.TypedAST;
import wyvern.tools.typedAST.typedastvisitor.TypedASTVisitor;

public class RecDeclaration extends Declaration implements CoreAST {
	
	private ExpressionAST body;
	
	// constructor
	public RecDeclaration(TypedAST body) {
		System.out.println();
		System.out.println("RecDeclaration Called.");
		System.out.println("	RecDeclaration Body: " + body); // debugger
		System.out.println();
		this.body = (ExpressionAST) body;
	}

	@Override
	public <S, T> T acceptVisitor(TypedASTVisitor<S, T> visitor, S state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeclType genILType(GenContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public wyvern.target.corewyvernIL.decl.Declaration generateDecl(GenContext ctx, GenContext thisContext) {
		return null;
	}

	@Override
	public wyvern.target.corewyvernIL.decl.Declaration topLevelGen(GenContext ctx, List<TypedModuleSpec> dependencies) {
		//return generateDecl(ctx, ctx);
		return null;
	}

	@Override
	public FileLocation getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
}
