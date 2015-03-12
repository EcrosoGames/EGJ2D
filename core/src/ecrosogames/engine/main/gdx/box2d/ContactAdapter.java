package ecrosogames.engine.main.gdx.box2d;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * A simple adapter for LibGDX's {@link ContactListener}. It's used to make
 * source code cleaner when the programmer doesn't use every single method from
 * the {@link ContactListener}.
 * 
 * @author Michael Musgrove
 */
public class ContactAdapter implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		;
	}

	@Override
	public void endContact(Contact contact) {
		;
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		;
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		;
	}
}
