package com.codingame.gameengine.module.entities;

import java.util.Objects;
/**
 * Generic type for entities containing text.
 * @param <T> a subclass inheriting TextureBasedEntity, used in order to return <b>this</b> as a T instead of a <code>TextBasedEntity</code>.
 */
public abstract class TextBasedEntity<T extends TextureBasedEntity<?>> extends TextureBasedEntity<T> {
    /**
     * This is an enumeration that contains the three options for text alignment: left, center, and right.
     */
    public static enum TextAlign {
        /**
         * Align text left
         */
        LEFT(0),
        /**
         * Align text center
         */
        CENTER(1),
        /**
         * Align text right
         */
        RIGHT(2);

        private int value;

        private TextAlign(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }
    protected String text = "";
    protected int fontSize = 26;
    protected TextAlign textAlign;
    
    /**
     * Returns the string this <code>TextBasedEntity</code> displays.
     * <p>
     * Default is "" (empty string).
     * 
     * @return the string of this <code>TextBasedEntity</code>.
     */
    public String getText() {
        return text;
    }
    

    /**
     * Sets the string for this <code>TextBasedEntity</code> to display.
     * 
     * @param text
     *            the string for this <code>TextBasedEntity</code> to display.
     * @return this <code>Text</code>.
     * @exception NullPointerException
     *                if text is null.
     */
    public T setText(String text) {
        Objects.requireNonNull(text);
        this.text = text;
        set("text", text, null);
        return self();
    }
    /**
     * Returns text alignment of this <code>TextBasedEntity</code>.
     * <p>
     * Default is TextAlign.LEFT (align left).
     * 
     * @return the text alignment of this <code>TextBasedEntity</code>.
     */
    public TextAlign getTextAlign() {
        return textAlign;
    }
    

    /**
     * Sets the text alignment of this <code>TextBasedEntity</code>.
     * 
     * @param align
     *            the text alignment of this <code>TextBasedEntity</code>.
     * @return this <code>Text</code>.
     * @exception NullPointerException
     *                if align is null.
     */
    public T setTextAlign(TextAlign align) {
        Objects.requireNonNull(align);
        this.textAlign = align;
        set("textAlign", align.getValue(), null);
        return self();
    }
    
    /**
     * Returns the size of the font of this <code>TextBasedEntity</code> in px.
     * <p>
     * Default is 26.
     * 
     * @return the size of the font of this <code>TextBasedEntity</code>.
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Sets the size of the font of this <code>TextBasedEntity</code> in px.
     * 
     * 
     * @param fontSize
     *            the size for the font of this <code>TextBasedEntity</code>.
     * @return this <code>Text</code>.
     */
    public T setFontSize(int fontSize) {
        return setFontSize(fontSize, null);
    }

    /**
     * Sets the size of the font of this <code>TextBasedEntity</code> in px.
     * 
     * 
     * @param fontSize
     *            the size for the font of this <code>TextBasedEntity</code>.
     * @param curve
     *            the transition to animate between values of this property.
     * @return this <code>Text</code>.
     */
    public T setFontSize(int fontSize, Curve curve) {
        this.fontSize = fontSize;
        set("fontSize", fontSize, curve);
        return self();
    }
}
