+++
title = "lspci（LPIC）"
url = "2022-10-03"
date = "2022-10-03"
description = "lspci（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# lspci

システムのすべてのPCIバスと、接続されているデバイスに関する情報を表示するコマンドです。

```
$ lspci
```

```
00:00.0 Host bridge: Intel Corporation 440FX - 82441FX PMC [Natoma] (rev 02)
00:01.0 ISA bridge: Intel Corporation 82371SB PIIX3 ISA [Natoma/Triton II]
00:01.1 IDE interface: Intel Corporation 82371SB PIIX3 IDE [Natoma/Triton II]
00:01.2 USB controller: Intel Corporation 82371SB PIIX3 USB [Natoma/Triton II] (rev 01)
00:01.3 Bridge: Intel Corporation 82371AB/EB/MB PIIX4 ACPI (rev 03)
00:02.0 VGA compatible controller: Device 1234:1111
00:03.0 Ethernet controller: Red Hat, Inc. Virtio network device
00:04.0 Communication controller: Red Hat, Inc. Virtio console
00:05.0 SCSI storage controller: Red Hat, Inc. Virtio block device
00:06.0 Unclassified device [00ff]: Red Hat, Inc. Virtio memory balloon
```

```
$ lspci -v
```

```
00:00.0 Host bridge: Intel Corporation 440FX - 82441FX PMC [Natoma] (rev 02)
	Subsystem: Red Hat, Inc. Qemu virtual machine
	Flags: fast devsel

00:01.0 ISA bridge: Intel Corporation 82371SB PIIX3 ISA [Natoma/Triton II]
	Subsystem: Red Hat, Inc. Qemu virtual machine
	Physical Slot: 1
	Flags: medium devsel

00:01.1 IDE interface: Intel Corporation 82371SB PIIX3 IDE [Natoma/Triton II] (prog-if 80 [ISA Compatibility mode-only controller, supports bus mastering])
	Subsystem: Red Hat, Inc. Qemu virtual machine
	Physical Slot: 1
	Flags: bus master, medium devsel, latency 0
	Memory at 000001f0 (32-bit, non-prefetchable) [virtual] [size=8]
	Memory at 000003f0 (type 3, non-prefetchable) [virtual]
	Memory at 00000170 (32-bit, non-prefetchable) [virtual] [size=8]
	Memory at 00000370 (type 3, non-prefetchable) [virtual]
	I/O ports at c0c0 [virtual] [size=16]
	Kernel driver in use: ata_piix
	Kernel modules: pata_acpi

00:01.2 USB controller: Intel Corporation 82371SB PIIX3 USB [Natoma/Triton II] (rev 01) (prog-if 00 [UHCI])
	Subsystem: Red Hat, Inc. QEMU Virtual Machine
	Physical Slot: 1
	Flags: bus master, fast devsel, latency 0, IRQ 11
	I/O ports at c040 [size=32]
	Kernel driver in use: uhci_hcd

00:01.3 Bridge: Intel Corporation 82371AB/EB/MB PIIX4 ACPI (rev 03)
	Subsystem: Red Hat, Inc. Qemu virtual machine
	Physical Slot: 1
	Flags: medium devsel, IRQ 9
	Kernel driver in use: piix4_smbus
	Kernel modules: i2c_piix4

00:02.0 VGA compatible controller: Device 1234:1111 (prog-if 00 [VGA controller])
	Subsystem: Red Hat, Inc. Device 1100
	Physical Slot: 2
	Flags: fast devsel
	Memory at fd000000 (32-bit, prefetchable) [size=16M]
	Memory at febd0000 (32-bit, non-prefetchable) [size=4K]
	Expansion ROM at 000c0000 [disabled] [size=128K]
	Kernel driver in use: bochs-drm
	Kernel modules: bochs

00:03.0 Ethernet controller: Red Hat, Inc. Virtio network device
	Subsystem: Red Hat, Inc. Virtio network device
	Physical Slot: 3
	Flags: bus master, fast devsel, latency 0, IRQ 10
	I/O ports at c060 [size=32]
	Memory at febd1000 (32-bit, non-prefetchable) [size=4K]
	Expansion ROM at feb80000 [disabled] [size=256K]
	Capabilities: [40] MSI-X: Enable+ Count=3 Masked-
	Kernel driver in use: virtio-pci

00:04.0 Communication controller: Red Hat, Inc. Virtio console
	Subsystem: Red Hat, Inc. Virtio console
	Physical Slot: 4
	Flags: bus master, fast devsel, latency 0, IRQ 11
	I/O ports at c080 [size=32]
	Memory at febd2000 (32-bit, non-prefetchable) [size=4K]
	Capabilities: [40] MSI-X: Enable+ Count=2 Masked-
	Kernel driver in use: virtio-pci

00:05.0 SCSI storage controller: Red Hat, Inc. Virtio block device
	Subsystem: Red Hat, Inc. Virtio block device
	Physical Slot: 5
	Flags: bus master, fast devsel, latency 0, IRQ 10
	I/O ports at c000 [size=64]
	Memory at febd3000 (32-bit, non-prefetchable) [size=4K]
	Capabilities: [40] MSI-X: Enable+ Count=2 Masked-
	Kernel driver in use: virtio-pci

00:06.0 Unclassified device [00ff]: Red Hat, Inc. Virtio memory balloon
	Subsystem: Red Hat, Inc. Virtio memory balloon
	Physical Slot: 6
	Flags: bus master, fast devsel, latency 0, IRQ 11
	I/O ports at c0a0 [size=32]
	Kernel driver in use: virtio-pci
```

