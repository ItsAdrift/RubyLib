package me.itsadrift.rubylib.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldguard.bukkit.BukkitUtil;
import org.bukkit.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SchematicUtils {

    public static void pasteSchematic(Location location, File file) {
        Clipboard clipboard = null;

        ClipboardFormat format = ClipboardFormats.findByFile(file);
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            clipboard = reader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(BukkitAdapter.adapt(location.getWorld()))) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(location.getBlockX(), location.getBlockY(), location.getBlockZ()))
                    // configure here
                    .build();
            Operations.complete(operation);
        } catch (WorldEditException e) {
            e.printStackTrace();
        }
    }

}
