package org.burgersim.pgeg.client.book.fragment;

import org.burgersim.pgeg.client.book.IPageFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentLinksList implements IPageFragment {

    private final int offsetX;
    private final int offsetY;
    private final LinkProvider linkProvider;
    private final int color;
    private List<FragmentLink> links = new ArrayList<>();

    public FragmentLinksList(int offsetX, int offsetY, LinkProvider linkProvider, int color) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.linkProvider = linkProvider;
        this.color = color;
        int linksCount = linkProvider.getSize();
        for (int i = 0; i < linksCount; i++) {
            links.add(new FragmentLink(offsetX + 16, offsetY + i * 16, i + linkProvider.getOffet(), 146, 4210752, linkProvider.getIcon(i), linkProvider.getText(i)) {
                @Override
                public boolean onMouseClicked(double x, double y, int mode) {
                    return linkProvider.onMouseClicked(this, x, y, mode);
                }
            });
        }
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        links.forEach(fragmentLink -> fragmentLink.draw(x, y, mouseX, mouseY));
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        boolean flag = false;
        for (FragmentLink link : links) {
            flag = link.onMouseClicked(x, y, mode);
        }
        return flag;
    }


}
