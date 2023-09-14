package editor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import base.editor.core.BoundingBox;

public class BoundingBoxTest
{
	private BoundingBox boundingBox;

	@Test
	public void testConstructorWithInitialPoint()
	{
		boundingBox = new BoundingBox(100, 80);
		assertEquals(100, boundingBox.getX());
		assertEquals(80, boundingBox.getY());
		assertEquals(0, boundingBox.getWidth());
		assertEquals(0, boundingBox.getHeight());
	}

	@Test
	public void testConstructorsWithInitialAndFinalPoints()
	{
		// 1: el usuario movió el ratón hacia la derecha y hacia abajo
		boundingBox = new BoundingBox(100, 80, 250, 200);
		assertEquals(100, boundingBox.getX());
		assertEquals(80, boundingBox.getY());
		assertEquals(150, boundingBox.getWidth());
		assertEquals(120, boundingBox.getHeight());
		// 2: el usuario movió el ratón hacia la izquierda y hacia abajo
		boundingBox = new BoundingBox(100, 80, -25, 150);
		assertEquals(-25, boundingBox.getX());
		assertEquals(80, boundingBox.getY());
		assertEquals(125, boundingBox.getWidth());
		assertEquals(70, boundingBox.getHeight());
		// 3: el usuario movió el ratón hacia la izquierda y hacia arriba
		boundingBox = new BoundingBox(100, 80, 50, 25);
		assertEquals(50, boundingBox.getX());
		assertEquals(25, boundingBox.getY());
		assertEquals(50, boundingBox.getWidth());
		assertEquals(55, boundingBox.getHeight());
		// 4: el usuario movió el ratón hacia la derecha y hacia arriba
		boundingBox = new BoundingBox(100, 80, 200, 50);
		assertEquals(100, boundingBox.getX());
		assertEquals(50, boundingBox.getY());
		assertEquals(100, boundingBox.getWidth());
		assertEquals(30, boundingBox.getHeight());
	}

	@Test
	public void testResize()
	{
		boundingBox = new BoundingBox(100, 100);
		boundingBox.resizeTo(300, 200);
		boundingBox.resizeTo(80, 20);
		boundingBox.resizeTo(-1024, 12);
		boundingBox.resizeTo(3000, -9999);
		boundingBox.resizeTo(300, 200);
		assertEquals(100, boundingBox.getX());
		assertEquals(100, boundingBox.getY());
		assertEquals(200, boundingBox.getWidth());
		assertEquals(100, boundingBox.getHeight());
	}
}
